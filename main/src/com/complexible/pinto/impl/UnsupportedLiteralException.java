package com.complexible.pinto.impl;

import static com.complexible.common.io.MMapUtil.LOGGER;

public class UnsupportedLiteralException extends RuntimeException {

        public UnsupportedLiteralException(String s) {
            LOGGER.info(s);
        }

}
