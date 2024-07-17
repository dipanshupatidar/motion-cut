# Java-URL-shortener
Assignment: Make an HTTP service that serves to shorten URLs, with the following functionalities:<br>
 Registration Web address (API) <br>
 Redirect client in accordance with the shortened URL <br>
 Usage Statistics (API)<br>

a) Opening of accounts HTTP method POST<br>
URI /account<br>
Request type application/json<br>
Request Body JSON object with the following parameters:<br>
 AccountId (String, mandatory)<br>
Example: { AccountId : 'myAccountId'}<br>
Reponse Type application/json<br>
Response We distinguish the successful from the unsuccessful registration.<br>
Unsuccessful registration occurs only if the concerned account ID <br>
already exists. The parameters are as follows:<br>
 success: true | false<br>
 description: Description of status, for example: account with that ID already exists<br>
 password: Returns only if the account was successfully created.<br>
Automatically generated password length of 8 alphanumeric characters<br>
Example {success: 'true', description: 'Your account is opened', password: 'xC345Fc0'}<br>

b) Registration of URLs<br>
HTTP metoda POST<br>
URI /register<br>
Request type application/json<br>
Request Headers Authorization header with Basic authentication token<br>
JSON object with the following parameters:<br>
 url (mandatory, url that needs shortening)<br>
 redirectType : 301 | 302 (not mandatory, default 302)<br>
Request Body Example: {<br>
url: 'http://stackoverflow.com/questions/1567929/website-safe-dataaccess-architecture-question?rq=1',<br>
redirectType : '301'<br>
} <br>
Reponse Type application/json<br>
Response parameters in case of successful registration are as follows:<br>
Response  shortUrl (shortened URL)<br>
Example: { shortUrl: 'http://short.com/xYswlE'}<br>

c) Retrieval of statistics HTTP metoda GET<br>
URI /statistic/{AccountId}<br>
Request Headers Set Authorization header and authenticate user<br>
Reponse Type application/json<br>
The server responds with a JSON object, key:value map, where the key<br>
is the registered URL, and the value is the number of this URL redirects..<br>
Example:<br>
{<br>
Response 'http://myweb.com/someverylongurl/thensomedirectory/: 10,<br>
'http://myweb.com/someverylongurl2/thensomedirectory2/: 4,<br>
'http://myweb.com/someverylongurl3/thensomedirectory3/: 91,<br>
}<br>

d) You can redirect your link at URI /<br>
Example : /http://short.com/xYswlE
