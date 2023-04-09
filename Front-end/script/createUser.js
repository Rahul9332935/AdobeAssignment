const userform = document.getElementById('createUserForm');
    info1 = document.getElementById('info1')
    userform.addEventListener('submit', event => {
        event.preventDefault();

        const userformData = new FormData(userform);
        console.log(userformData.get("name"));
        const user = {
            name: userformData.get("name"),
            email: userformData.get("email"),
            bio: userformData.get("bio"),
        };


        fetch('https://adobeassignment-production.up.railway.app/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        })
            .then(response => response.json())
            .then(data => {
                console.log('User created:', data.name);
                info1.innerText = null;
                if (data.id == undefined) {
                    info1.append(data.message)
                    alert(data.message)
                } else {
                    info1.append("user created / user id =" + data.id)
                    alert("user id -" + data.id)
                }
                userform.reset();
            })
            .catch(error => console.error('Error creating user:', error));
    });