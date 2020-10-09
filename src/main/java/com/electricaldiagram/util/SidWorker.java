package com.electricaldiagram.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Zkl
 * @create: 2010-10-09
 * @Description: 生成时间戳 格式：20160628175532000002
 */
public class SidWorker {
    private static final long MAX_SEQUENCE = 100;
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static long lastTimestamp = -1L;
    private static int sequence = 0;

    /**
     * 19 bits number with timestamp (20160628175532000002)
     *
     * @return 19 bits number with timestamp
     */
    public static synchronized long nextSid() {
        long now = timeGen();
        if (now == lastTimestamp) {
            if (sequence++ > MAX_SEQUENCE) {
                now = tilNextMillis(lastTimestamp);
                sequence = 0;
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = now;
        //
        return 100L * Long.parseLong(format.format(new Date(now))) + sequence;
    }

    private static long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private static long timeGen() {
        return System.currentTimeMillis();
    }
}
