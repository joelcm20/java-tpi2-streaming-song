package com.informatorio.tpi2.domain;

import java.util.List;

public class PlayList extends Audit {
    private User user;
    private List<Song> songs;
    private Boolean loop;
    private Boolean random;
    private Boolean isPublic;
}
