🎵 Playlist Manager - Doubly & Singly Linked List Implementation
📌 Overview
This project implements a Playlist Manager using Singly and Doubly Linked Lists in Java. It supports various operations such as adding, removing, searching, moving, and reversing songs in the playlist. Additionally, it allows users to navigate between songs and prevents the removal of the currently playing song.

🚀 Features
Add a song to the playlist (at the end).
Remove a song, except the currently playing song.
Search for a song by title.
Move a song to a specific position.
Reverse the playlist to play in the opposite order.
Navigate between songs using playNext() and playPrevious().
🛠️ Implementation Details
🔹 Node Structure
Each song is stored in a Node that contains:

A Song object (title, artist, duration).
A reference to the next node.
A reference to the previous node (in doubly linked list).
🔹 Singly Linked List
Implements a basic playlist where each node points only to the next song.
No ability to move backward.
Operations: addSong(), removeSong(), searchSong(), reversePlaylist(), displayPlaylist().
🔹 Doubly Linked List
Each node points to both the next and previous song.
Supports playNext() and playPrevious().
Extra method removeSongForMoveSongMethod() to enable song movement.
Operations: addSong(), removeSong(), searchSong(), moveSong(), reversePlaylist(), displayPlaylist().
📖 How It Works
🔹 Adding a Song
java
Copy
Edit
playlist.addSong("Shape of You", "Ed Sheeran", 240);
If the playlist is empty, the song is set as the head (and tail).
Otherwise, the song is added at the end.
🔹 Removing a Song
java
Copy
Edit
playlist.removeSong("Shape of You");
Cannot remove the currently playing song.
Handles removal from head, tail, or middle.
🔹 Searching for a Song
java
Copy
Edit
playlist.searchSong("Shape of You");
Traverses the list and returns the song details if found.
🔹 Moving a Song
java
Copy
Edit
playlist.moveSong("Shape of You", 2);
Moves the song to a new position while maintaining pointer integrity.
Uses a helper removal method to ensure proper shifting.
🔹 Reversing the Playlist
java
Copy
Edit
playlist.reversePlaylist();
Swaps next and prev pointers for each node.
Updates head and tail accordingly.
🔹 Playing Songs
java
Copy
Edit
playlist.playNext();
playlist.playPrevious();
Moves to the next or previous song, updating currentSong.

