package com.complexible.pinto.impl;

import static com.complexible.common.io.MMapUtil.LOGGER;

public class MyOwnRuntime extends RuntimeException {

        public MyOwnRuntime(String s) {
            LOGGER.info(s);
        }

}
