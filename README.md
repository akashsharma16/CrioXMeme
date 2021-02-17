# CrioXMeme

This is the backend code of my xmeme app that I developed using Spring boot.

**XMeme API Documentation**

1. **Post Meme Data API**

Public Url: https://crio-xmeme-akash.herokuapp.com/memes

Meme Data goes in Request Body

| Meme Data | Data Type | Constriant |
| ------ | ------ | ------ |
| name | string | Not Empty |
| caption | string | Not Empty |
| url | string | Not Empty |

Response contains

    1. `id` if meme is posted successfully
    2. `message` if any data passed in empty with error code 404 or if same payload is posted again with error code 409 

2. **Get Meme Data API**

Public Url: https://crio-xmeme-akash.herokuapp.com/memes

Response will contains a list of 100 latest meme posted on our app.

| Data Name | Data Type |
| ------ | ------ |
| id | Long |
| name | String |
| caption | String |
| url | String |

3. **Get Meme Data By MemeId API**

Public Url: https://crio-xmeme-akash.herokuapp.com/memes/{memeId}

Response will contain a meme data.

| Data Name | Data Type |
| ------ | ------ |
| id | Long |
| name | String |
| caption | String |
| url | String |

4. **Patch Meme Data By memeId API**

Public Url: https://crio-xmeme-akash.herokuapp.com/memes/{memeId}

Meme Data goes in Request Body

| Data Name | Data Type | Constriant |
| ------ | ------ | ------ |
| caption | string | Not Empty |
| url | string | Not Empty |

Response contains

    1. `message: Meme Updated Successfully` if meme is posted successfully
    2. `message` if any data passed is empty with error code 404 or if same payload is posted again with error code 409 
    
