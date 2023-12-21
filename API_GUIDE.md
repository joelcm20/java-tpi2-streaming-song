# API GUIDE

## song endpoint
- Parameter filter: name, genre, artist, album
- get all songs: [GET] /api/song?name=[name_song]&genre=[genre]&artist=[artist]&album=[album]
- get songs by specific artist ordered by ranking: [GET] /api/song?artist=[artist_name]

## artist endpoint
- get artist by id: [GET] /api/artist/[id]

## playlist endpoint
- get all playlists: [GET] /api/playlist
- get public playlists by name: [GET] /api/playlist?name=[playlist_name]
- get user playlists by id ordered by created at: [GET] /api/playlist/user/[user_id]
- get playlist songs by id: [GET] /api/playlist/songs/[playlist_id]
- add song to playlist: [POST] /api/playlist/[playlist_id]/add/[song_id]
    > request body
  > {
  > "userId": "userid" (playlist owner)
  > }
- delete song from playlist: [DELETE] /api/playlist/[playlist_id]/delete/[song_id]
  > request body
  > {
  > "userId": "userid" (playlist owner)
  > }
    
- create playlist: [POST] /api/playlist
    > request body
    > {"name": "playlist name",
    >  "user": "userid",
    >  "loop": true|false,
    >  "random": true|false,
    >  "isPublic": true|false,
    >  "songs": ["id1", "id2", ...]}

## user endpoint
- create user: [POST] /api/user
 > request body
 > {
 >  "name": "name",
 >  "username": "username",
 >  "playLists": ["id1", "id2", ...]
 > }
- get user information: [GET] /api/user/info/[id_user]
- get all users: [GET] /api/user