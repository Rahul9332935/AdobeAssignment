// Fetch user data from the API
fetch('https://adobeassignment-production.up.railway.app/users')
.then(response => response.json())
.then(data => {
    // Loop through the user data and append it to the table
    data.forEach(user => {
        const row = document.createElement('tr');
        row.innerHTML = `
<td>${user.id}</td>
<td>${user.name}</td>
<td>${user.email}</td>
<td><button  onclick="deleteUser(${user.id})">Delete</button></td>`;
        document.getElementById('userData').getElementsByTagName('tbody')[0].appendChild(row);
    });
})
.catch(error => {
    console.error('Error fetching user data:', error);
});

// Function to delete a user 
function deleteUser(userID) {
// Send a DELETE request to the API with the user ID
fetch(`https://adobeassignment-production.up.railway.app/users/${userID}`, { method: 'DELETE' })
    .then(response => response.json())
    .then(data => {
        alert("user with id -" + userID + " got deleted ")
        window.location.reload();
    })
    .catch(error => {
        console.error(`Error deleting user ${userID}:`, error);
    });
}


const postApi = 'https://adobeassignment-production.up.railway.app/posts';
async function makerequest() {
    let res = await fetch(postApi);
    let data = await res.json();
    if (Response) {
        show(data)

    }
}

function show(data) {
    console.log(data)
    data.forEach(post => {
        const row = document.createElement('tr');
        row.innerHTML = `
        <td>${post.id}</td>
    <td>${post.user.name}</td>
    <td>${post.user.id}</td>
    <td>${post.content}</td>
    <td>${post.likes}</td>
    <td>
      <button onclick="likePost(${post.id})">Like</button>
    </td>
    <td><button onclick="unlikePost(${post.id})">unLike</button></td>
    <td><button onclick="deletePost(${post.id})">Delete</button></td>`;
        document.getElementById('postTable').getElementsByTagName('tbody')[0].appendChild(row);
    });
}

makerequest();




//Function to like a post
function likePost(postId) {
    fetch(`https://adobeassignment-production.up.railway.app/posts/${postId}/like`, {
        method: 'POST'
    })
        .then(response => response.json())
        .then(data => {

            alert("you liked a post")
            window.location.reload();
        })
        .catch(error => {
            console.error('Error liking post:', error);
        });
}

//Function to unlike a post
function unlikePost(postId) {
    fetch(`https://adobeassignment-production.up.railway.app/posts/${postId}/unlike`, {
        method: 'POST'
    })
        .then(response => response.json())
        .then(data => {

            alert("you disliked a post")
            window.location.reload();
        })
        .catch(error => {
            console.error('Error unliking post:', error);
        });
}

// Function to delete a post from the table and the database
function deletePost(postID) {
    // Send a DELETE request to the API with the post ID
    fetch(`https://adobeassignment-production.up.railway.app/posts/${postID}`, { method: 'DELETE' })
        .then(response => response.json())
        .then(data => {

            alert("post with id = " + postID + " got deleted")
            window.location.reload();
        })
        .catch(error => {
            console.error(`Error deleting post ${postID}:`, error);
        });
}

