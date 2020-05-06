package com.funcode.example.chapter7.util.base64;

public interface BinaryDecoder extends Decoder {

    byte[] decode(byte[] source) throws DecoderException;
}
