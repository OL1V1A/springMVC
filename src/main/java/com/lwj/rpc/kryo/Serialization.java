package com.lwj.rpc.kryo;

import java.io.IOException;

/**
 * @Auth: lwj
 * @Date: 2019/6/25 13:30
 */
public interface Serialization {

    byte[] serialize(Object obj) throws IOException;

    <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException;

}
