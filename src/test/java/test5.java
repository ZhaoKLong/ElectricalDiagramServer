import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class test5 {
    /**
     * 远程文件下载
     *
     * @param url  下载地址
     * @param file 保存文件地址
     */
    private static boolean download(URL url, File file) throws IOException {
        boolean flag = true;
        DataOutputStream dos = null;
        DataInputStream dis = null;
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            dos = new DataOutputStream(new FileOutputStream(file));
            dis = new DataInputStream(conn.getInputStream());
            byte[] data = new byte[2048];
            int i = 0;
            while ((i = dis.read(data)) != -1) {
                dos.write(data, 0, i);
            }
            dos.flush();
        } catch (IOException e) {
            flag = false;
            throw e;
        } finally {
            if (dis != null) {
                dis.close();
            }
            if (dos != null) {
                dos.close();
            }
        }
        return flag;
    }

    /**
     * 根据经度获取切片规范下的行号
     */
    private static int getOSMTileXFromLongitude(double lon, int zoom) {
        return (int) (Math.floor((lon + 180) / 360 * Math.pow(2, zoom)));
    }

    /**
     * 根据纬度获取切片规范下的列号
     */
    private static int getOSMTileYFromLatitude(double lat, int zoom) {
        return (int) (Math.floor((1 - Math.log(Math.tan(lat * Math.PI / 180) + 1 / Math.cos(lat * Math.PI / 180)) / Math.PI) / 2 * Math.pow(2, zoom)));
    }

    public static void main(String[] arg) throws IOException {
        // 乌拉特后旗
//        double[] extent = {105.198, 40.691, 107.625, 42.362};
        // 乌拉特中旗
        double[] extent = {107.261, 41.130, 109.698, 42.458};
        // 乌拉特前旗
//        double[] extent = {108.170, 40.455, 109.898, 41.268};
        // 五原县
//        double[] extent = {107.593, 40.756, 108.626, 41.279};
        // 磴口县
//        double[] extent = {106.153, 40.167, 107.168, 40.953};
        // 杭锦后旗
//        double[] extent = {106.589, 40.459, 107.387, 41.221};
        // 临河区
//        double[] extent = {107.104, 40.556, 107.726, 41.277};
        int count = 0;
        for (int z = 14; z < 16; z++) {
            //计算行列号(使用瓦片的中心点经纬度计算)
            //起始结束行
            int minR = getOSMTileYFromLatitude(extent[3], z);
            int maxR = getOSMTileYFromLatitude(extent[1], z);
            //起始结束列
            int minC = getOSMTileXFromLongitude(extent[0], z);
            int maxC = getOSMTileXFromLongitude(extent[2], z);
            for (int y = minR; y <= maxR; y++) {
                for (int x = minC; x <= maxC; x++) {
                    count++;
                    //高德地图(6：影像，7：矢量，8：影像路网)
//                    String urlstr = "http://wprd04.is.autonavi.com/appmaptile?x=" + x + "&y=" + y + "&z=" + z + "&lang=zh_cn&size=1&scl=1&style=6";
                    //谷歌地图（反爬虫）
                    String urlstr = "http://mt" + (x % 4) + ".google.cn/vt/lyrs=s&scale=1&hl=zh-CN&gl=cn&x=" + x + "&y=" + y + "&z=" + z;
                    System.out.println(urlstr);
                    String path = null;
                    //一般格式瓦片下载
                    path = getTDTilesForCustomPath(x, y, z);
                    File file = new File(path);
                    if (!file.exists() || file.length() == 0) {
                        URL url = new URL(urlstr);
                        download(url, file);
                        System.out.println(count);
                    }
                }
            }
        }
    }

    private static String getTDTilesForCustomPath(int x, int y, int z) {
        return "D:/work/maps/byne/wltzq-google/" + z + "-" + y + "-" + x + ".png";
    }
}