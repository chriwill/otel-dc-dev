/*
 * (c) Copyright IBM Corp. 2023
 * (c) Copyright Instana Inc.
 */
package com.instana.dc.rdb;

import com.instana.dc.RawMetric;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.instana.dc.InstrumentType.GAUGE;
import static com.instana.dc.InstrumentType.UPDOWN_COUNTER;
import static com.instana.dc.rdb.DbDcUtil.*;

public class DbRawMetricRegistry {
    private final Map<String, RawMetric> map = new ConcurrentHashMap<String, RawMetric>() {{
        put(DB_STATUS_NAME, new RawMetric(GAUGE, DB_STATUS_NAME, DB_STATUS_DESC, DB_STATUS_UNIT, true, null));
        put(DB_INSTANCE_COUNT_NAME, new RawMetric(UPDOWN_COUNTER, DB_INSTANCE_COUNT_NAME, DB_INSTANCE_COUNT_DESC, DB_INSTANCE_COUNT_UNIT, true, null));
        put(DB_INSTANCE_ACTIVE_COUNT_NAME, new RawMetric(UPDOWN_COUNTER, DB_INSTANCE_ACTIVE_COUNT_NAME, DB_INSTANCE_ACTIVE_COUNT_DESC, DB_INSTANCE_ACTIVE_COUNT_UNIT, true, null));

        put(DB_SESSION_COUNT_NAME, new RawMetric(UPDOWN_COUNTER, DB_SESSION_COUNT_NAME, DB_SESSION_COUNT_DESC, DB_SESSION_COUNT_UNIT, true, null));
        put(DB_SESSION_ACTIVE_COUNT_NAME, new RawMetric(UPDOWN_COUNTER, DB_SESSION_ACTIVE_COUNT_NAME, DB_SESSION_ACTIVE_COUNT_DESC, DB_SESSION_ACTIVE_COUNT_UNIT, true, null));
        put(DB_TRANSACTION_COUNT_NAME, new RawMetric(UPDOWN_COUNTER, DB_TRANSACTION_COUNT_NAME, DB_TRANSACTIONS_COUNT_DESC, DB_TRANSACTION_COUNT_UNIT, true, null));
        put(DB_TRANSACTION_RATE_NAME, new RawMetric(GAUGE, DB_TRANSACTION_RATE_NAME, DB_TRANSACTION_RATE_DESC, DB_TRANSACTION_RATE_UNIT, false, null));
        put(DB_TRANSACTION_LATENCY_NAME, new RawMetric(GAUGE, DB_TRANSACTION_LATENCY_NAME, DB_TRANSACTION_LATENCY_DESC, UNIT_S, false, null));
        put(DB_SQL_COUNT_NAME, new RawMetric(UPDOWN_COUNTER, DB_SQL_COUNT_NAME, DB_SQL_COUNT_DESC, DB_SQL_COUNT_UNIT, true, null));
        put(DB_SQL_RATE_NAME, new RawMetric(GAUGE, DB_SQL_RATE_NAME, DB_SQL_RATE_DESC, DB_SQL_RATE_UNIT, false, null));
        put(DB_SQL_LATENCY_NAME, new RawMetric(GAUGE, DB_SQL_LATENCY_NAME, DB_SQL_LATENCY_DESC, UNIT_S, false, null));
        put(DB_IO_READ_RATE_NAME, new RawMetric(GAUGE, DB_IO_READ_RATE_NAME, DB_IO_READ_RATE_DESC, UNIT_BY, false, null));
        put(DB_IO_WRITE_RATE_NAME, new RawMetric(GAUGE, DB_IO_WRITE_RATE_NAME, DB_IO_WRITE_RATE_DESC, UNIT_BY, false, null));
        put(DB_TASK_WAIT_COUNT_NAME, new RawMetric(UPDOWN_COUNTER, DB_TASK_WAIT_COUNT_NAME, DB_TASK_WAIT_COUNT_DESC, DB_TASK_WAIT_COUNT_UNIT, false, null));
        put(DB_TASK_AVG_WAIT_TIME_NAME, new RawMetric(GAUGE, DB_TASK_AVG_WAIT_TIME_NAME, DB_TASK_AVG_WAIT_TIME_DESC, UNIT_S, false, null));

        put(DB_CACHE_HIT_NAME, new RawMetric(GAUGE, DB_CACHE_HIT_NAME, DB_CACHE_HIT_DESC, UNIT_1, false, DB_CACHE_HIT_KEY));
        put(DB_SQL_ELAPSED_TIME_NAME, new RawMetric(UPDOWN_COUNTER, DB_SQL_ELAPSED_TIME_NAME, DB_SQL_ELAPSED_TIME_DESC, UNIT_S, false, DB_SQL_ELAPSED_TIME_KEY));
        put(DB_LOCK_COUNT_NAME, new RawMetric(UPDOWN_COUNTER, DB_LOCK_COUNT_NAME, DB_LOCK_COUNT_DESC, DB_LOCK_COUNT_UNIT, true, DB_LOCK_COUNT_KEY));
        put(DB_LOCK_TIME_NAME, new RawMetric(UPDOWN_COUNTER, DB_LOCK_TIME_NAME, DB_LOCK_TIME_DESC, UNIT_S, false, DB_LOCK_TIME_KEY));

        put(DB_TABLESPACE_SIZE_NAME, new RawMetric(UPDOWN_COUNTER, DB_TABLESPACE_SIZE_NAME, DB_TABLESPACE_SIZE_DESC, UNIT_BY, true, DB_TABLESPACE_SIZE_KEY));
        put(DB_TABLESPACE_USED_NAME, new RawMetric(UPDOWN_COUNTER, DB_TABLESPACE_USED_NAME, DB_TABLESPACE_USED_DESC, UNIT_BY, true, DB_TABLESPACE_USED_KEY));
        put(DB_TABLESPACE_UTILIZATION_NAME, new RawMetric(GAUGE, DB_TABLESPACE_UTILIZATION_NAME, DB_TABLESPACE_UTILIZATION_DESC, UNIT_1, false, DB_TABLESPACE_UTILIZATION_KEY));
        put(DB_TABLESPACE_MAX_NAME, new RawMetric(UPDOWN_COUNTER, DB_TABLESPACE_MAX_NAME, DB_TABLESPACE_MAX_DESC, UNIT_BY, true, DB_TABLESPACE_MAX_KEY));
        put(DB_CPU_UTILIZATION_NAME, new RawMetric(GAUGE, DB_CPU_UTILIZATION_NAME, DB_CPU_UTILIZATION_DESC, UNIT_1, false, null));
        put(DB_MEM_UTILIZATION_NAME, new RawMetric(GAUGE, DB_MEM_UTILIZATION_NAME, DB_MEM_UTILIZATION_DESC, UNIT_1, false, null));
        put(DB_DISK_UTILIZATION_NAME, new RawMetric(GAUGE, DB_DISK_UTILIZATION_NAME, DB_DISK_UTILIZATION_DESC, UNIT_1, false, DB_DISK_UTILIZATION_KEY));
        put(DB_DISK_USAGE_NAME, new RawMetric(UPDOWN_COUNTER, DB_DISK_USAGE_NAME, DB_DISK_USAGE_DESC, UNIT_BY, true, DB_DISK_USAGE_KEY));

        put(DB_DISK_WRITE_COUNT_NAME, new RawMetric(UPDOWN_COUNTER, DB_DISK_WRITE_COUNT_NAME, DB_DISK_WRITE_COUNT_DESC, DB_DISK_WRITE_COUNT_UNIT, true, null));
        put(DB_DISK_READ_COUNT_NAME, new RawMetric(UPDOWN_COUNTER, DB_DISK_READ_COUNT_NAME, DB_DISK_READ_COUNT_DESC, DB_DISK_READ_COUNT_UNIT, true, null));

        put(DB_BACKUP_CYCLE_NAME, new RawMetric(GAUGE, DB_BACKUP_CYCLE_NAME, DB_BACKUP_CYCLE_DESC, UNIT_S, true, null));

        put(DB_DATABASE_LOG_ENABLED_NAME, new RawMetric(GAUGE, DB_DATABASE_LOG_ENABLED_NAME, DB_DATABASE_LOG_ENABLED_DESC, UNIT_BY, true, DB_DATABASE_LOG_ENABLED_KEY));
        put(DB_DATABASE_BUFF_LOG_ENABLED_NAME, new RawMetric(GAUGE, DB_DATABASE_BUFF_LOG_ENABLED_NAME, DB_DATABASE_BUFF_LOG_ENABLED_DESC, UNIT_BY, true, DB_DATABASE_BUFF_LOG_ENABLED_KEY));
        put(DB_DATABASE_ANSI_COMPLAINT_NAME, new RawMetric(GAUGE, DB_DATABASE_ANSI_COMPLAINT_NAME, DB_DATABASE_ANSI_COMPLAINT_DESC, UNIT_BY, true, DB_DATABASE_ANSI_COMPLAINT_KEY));
        put(DB_DATABASE_NLS_ENABLED_NAME, new RawMetric(GAUGE, DB_DATABASE_NLS_ENABLED_NAME, DB_DATABASE_NLS_ENABLED_DESC, UNIT_BY, true, DB_DATABASE_NLS_ENABLED_KEY));
        put(DB_DATABASE_CASE_INCENSITIVE_NAME, new RawMetric(GAUGE, DB_DATABASE_CASE_INCENSITIVE_NAME, DB_DATABASE_CASE_INCENSITIVE_DESC, UNIT_BY, true, DB_DATABASE_CASE_INCENSITIVE_KEY));
        put(DB_LOCK_TABLE_OVERFLOW_NAME, new RawMetric(UPDOWN_COUNTER, DB_LOCK_TABLE_OVERFLOW_NAME, DB_LOCK_TABLE_OVERFLOW_DESC, DB_LOCK_TABLE_OVERFLOW_UNIT, true, null));
        put(DB_TRANSACTION_OVERFLOW_NAME, new RawMetric(UPDOWN_COUNTER, DB_TRANSACTION_OVERFLOW_NAME, DB_TRANSACTION_OVERFLOW_DESC, DB_TRANSACTION_OVERFLOW_UNIT, true, null));
        put(DB_USER_OVERFLOW_NAME, new RawMetric(UPDOWN_COUNTER, DB_USER_OVERFLOW_NAME, DB_USER_OVERFLOW_DESC, DB_USER_OVERFLOW_UNIT, true, null));
        put(DB_SEQ_SCAN_NAME, new RawMetric(UPDOWN_COUNTER, DB_SEQ_SCAN_NAME, DB_SEQ_SCAN_DESC, UNIT_BY, true, DB_SEQ_SCAN_KEY));
        put(DB_SEQ_SCAN_TABLE_NAME, new RawMetric(GAUGE, DB_SEQ_SCAN_TABLE_NAME, DB_SEQ_SCAN_TABLE_DESC, DB_SEQ_SCAN_TABLE_UNIT, true, null));

        put(DB_LOCK_WAITS_NAME, new RawMetric(UPDOWN_COUNTER, DB_LOCK_WAITS_NAME, DB_LOCK_WAITS_DESC, DB_LOCK_WAITS_UNIT, true, null));
        put(DB_CACHE_READ_RATIO_NAME, new RawMetric(GAUGE, DB_CACHE_READ_RATIO_NAME, DB_CACHE_READ_RATIO_DESC, DB_CACHE_READ_RATIO_UNIT, true, null));
        put(DB_CACHE_WRITE_RATIO_NAME, new RawMetric(GAUGE, DB_CACHE_WRITE_RATIO_NAME, DB_CACHE_WRITE_RATIO_DESC, DB_CACHE_WRITE_RATIO_UNIT, true, null));
        put(DB_LRU_WRITES_NAME, new RawMetric(UPDOWN_COUNTER, DB_LRU_WRITES_NAME, DB_LRU_WRITES_DESC, DB_LRU_WRITES_UNIT, true, null));
    }};

    public Map<String, RawMetric> getMap() {
        return map;
    }
}
