const updateUserform = document.getElementById('update-user-form');
    info2 = document.getElementById('info2')
    updateUserform.addEventListener('submit', event => {
        event.preventDefault();

        const updateUserformData = new FormData(updateUserform);
        console.log(updateUserformData.get("name"));
        const uUser = {
            userName: updateUserformData.get("name"),
            userEmail: updateUserformData.get("email"),
            userBio: updateUserformData.get("bio")
        };
        let userId = updateUserformData.get("userId");

        fetch(`https://adobeassignment-production.up.railway.app/users/${userId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(uUser)
        })
            .then(response => response.json())
            .then(data => {
                console.log('User updated:', data.name);
                info2.innerText = null;
                if (data.id == undefined) {
                    info2.append(data.message)
                    alert(data.message)
                } else {
                    info2.append("user updated / user id =" + data.id)
                    alert("user id -" + data.id)
                }
                userform.reset();
            })
            .catch(error => console.error('Error updating user:', error));
    });