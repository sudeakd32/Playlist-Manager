# 🎵 Playlist Manager - Doubly & Singly Linked List Implementation  

## 📌 Overview  
This project implements a **Playlist Manager** using **Singly and Doubly Linked Lists** in Java. It supports various operations such as adding, removing, searching, moving, and reversing songs in the playlist. Additionally, it allows users to navigate between songs and prevents the removal of the currently playing song.

## 🚀 Features  
- **Add a song** to the playlist.  
- **Remove a song** (except the currently playing one).  
- **Search for a song** by title.  
- **Move a song** to a specific position.  
- **Reverse the playlist** order.  
- **Play next/previous song** in a doubly linked list.  

## 🛠️ Implementation Details  
### 🔹 Node Structure  
Each song is stored in a `Node` that contains:  
- A **Song** object (title, artist, duration).  
- A reference to the **next** node.  
- A reference to the **previous** node (only in a doubly linked list).  

### 🔹 Singly Linked List  
- Implements a basic playlist where each node points only to the next song.  
- Operations: `addSong()`, `removeSong()`, `searchSong()`, `reversePlaylist()`, `displayPlaylist()`.  

### 🔹 Doubly Linked List  
- Supports **bi-directional navigation** between songs.  
- Includes extra logic for **moving** and **playing** songs.  
- Operations: `addSong()`, `removeSong()`, `searchSong()`, `moveSong()`, `reversePlaylist()`, `displayPlaylist()`.  


