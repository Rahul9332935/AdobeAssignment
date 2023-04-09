const form = document.getElementById('create-post-form');
    let info = document.getElementById('info');

    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const formData = new FormData(form);
        let userObj = {
            id: formData.get("user_id")
        }
        console.log(userObj);
        let obj = {
            "user": userObj,
            "content": formData.get("content")
        }
        console.log(obj);
        

        fetch('https://adobeassignment-production.up.railway.app/posts', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)
        })
            .then(response => response.json())
            .then(data => {
                console.log(data)
                info.innerText = null;
                if (data.id == undefined) {
                    info.append(data.message)
                    alert(data.message)
                } else {
                    info.append("post created / post id =" + data.id)
                    alert("post id -" + data.id)
                }


                form.reset();
            })
            .catch(error => console.error('Error creating post:', error));
    });