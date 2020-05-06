package com.funcode.example.chapter7.util.base64;

public interface BinaryEncoder extends Encoder {


    byte[] encode(byte[] source) throws EncoderException;
}
