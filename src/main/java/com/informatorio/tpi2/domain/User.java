package com.informatorio.tpi2.domain;

import java.util.UUID;

public class User extends Audit {
    private UUID id;
    private String name;
    private String userName;
    private PlayList playList;
}
