let postForm = document.getElementById('post-form');

    postForm.addEventListener('submit', event => {
        event.preventDefault();

        const updatePost = new FormData(postForm);

        const postDto = {
            postContent: updatePost.get('content')
        }

        let postId = updatePost.get('postId');
        console.log(postDto, postId);

        fetch(`https://adobeassignment-production.up.railway.app/posts/${postId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(postDto)
        })
            .then(response => response.json())
            .then(data => {
                console.log(data)
                info.innerText = null;
                if (data.id == undefined) {
                    info.append(data.message)
                    alert(data.message)
                } else {
                    info.append("post updated/ post id =" + data.id)
                    alert("post id -" + data.id)
                }


                form.reset();
            })
            .catch(error => console.error('Error creating post:', error));

    })