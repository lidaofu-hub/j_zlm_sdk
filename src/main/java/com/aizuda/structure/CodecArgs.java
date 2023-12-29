package com.aizuda.structure;

import com.sun.jna.Union;

public class CodecArgs extends Union {
    public Video video;
    public Audio audio;

    public static class Video extends SdkStructure {
        public int width;
        public int height;
        public int fps;
    }

    public static class Audio extends SdkStructure {
        public int channels;
        public int sample_rate;

    }
}