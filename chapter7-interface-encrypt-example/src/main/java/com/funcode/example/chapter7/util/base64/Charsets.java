package com.funcode.example.chapter7.util.base64;


import java.nio.charset.Charset;

public class Charsets {

    public static Charset toCharset(final Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static Charset toCharset(final String charset) {
        return charset == null ? Charset.defaultCharset() : Charset.forName(charset);
    }

    public static final Charset ISO_8859_1 = Charset.forName(CharEncoding.ISO_8859_1);


    public static final Charset US_ASCII = Charset.forName(CharEncoding.US_ASCII);


    public static final Charset UTF_16 = Charset.forName(CharEncoding.UTF_16);

    public static final Charset UTF_16BE = Charset.forName(CharEncoding.UTF_16BE);


    public static final Charset UTF_16LE = Charset.forName(CharEncoding.UTF_16LE);


    public static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);
}
