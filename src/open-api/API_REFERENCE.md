


# Api Reference


Base URL:

* <a href="http://localhost:8080">http://localhost:8080</a>

# Authentication

- HTTP Authentication, scheme: bearer JWT Auth Description

<h1 id="-login-controller">login-controller</h1>

## validateToken

<a id="opIdvalidateToken"></a>


`POST /validateToken`

<h3 id="validatetoken-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|token|query|string|true|none|

> Example responses

> 200 Response

<h3 id="validatetoken-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad Request|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

<h3 id="validatetoken-responseschema">Response Schema</h3>

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## registerUser

<a id="opIdregisterUser"></a>


`POST /registerUser`

<h3 id="registeruser-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|email|query|string|true|none|
|password|query|string|true|none|

> Example responses

> 200 Response

<h3 id="registeruser-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad Request|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

<h3 id="registeruser-responseschema">Response Schema</h3>

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## loginUser

<a id="opIdloginUser"></a>

`POST /login`

<h3 id="loginuser-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|email|query|string|true|none|
|password|query|string|true|none|

> Example responses

> 200 Response

<h3 id="loginuser-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad Request|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

<h3 id="loginuser-responseschema">Response Schema</h3>

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

<h1 id="-gender-controller">gender-controller</h1>

## getAllGender

<a id="opIdgetAllGender"></a>


`GET /gender/`

> Example responses

> 200 Response

<h3 id="getallgender-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad Request|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

<h3 id="getallgender-responseschema">Response Schema</h3>

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## postMethodName

<a id="opIdpostMethodName"></a>

`POST /gender/`

> Body parameter

```json
"string"
```

<h3 id="postmethodname-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|string|true|none|

> Example responses

> 200 Response

<h3 id="postmethodname-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad Request|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

<h3 id="postmethodname-responseschema">Response Schema</h3>

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

<h1 id="-content-controller">content-controller</h1>

## postMethodName_1

<a id="opIdpostMethodName_1"></a>


`POST /content/`

> Body parameter

```json
{
  "id": 0,
  "idProfile": 0,
  "nameContent": "string",
  "statusContent": "string",
  "qualification": 0,
  "comment": "string",
  "idGender": 0,
  "idPlatform": 0,
  "idType": 0
}
```

<h3 id="postmethodname_1-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[ContentDTO](#schemacontentdto)|true|none|

> Example responses

> 200 Response

<h3 id="postmethodname_1-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad Request|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not Found|Inline|

<h3 id="postmethodname_1-responseschema">Response Schema</h3>

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

# Schemas

<h2 id="tocS_ContentDTO">ContentDTO</h2>
<!-- backwards compatibility -->
<a id="schemacontentdto"></a>
<a id="schema_ContentDTO"></a>
<a id="tocScontentdto"></a>
<a id="tocscontentdto"></a>

```json
{
  "id": 0,
  "idProfile": 0,
  "nameContent": "string",
  "statusContent": "string",
  "qualification": 0,
  "comment": "string",
  "idGender": 0,
  "idPlatform": 0,
  "idType": 0
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int64)|false|none|none|
|idProfile|integer(int64)|false|none|none|
|nameContent|string|false|none|none|
|statusContent|string|false|none|none|
|qualification|integer(int32)|false|none|none|
|comment|string|false|none|none|
|idGender|integer(int64)|false|none|none|
|idPlatform|integer(int64)|false|none|none|
|idType|integer(int64)|false|none|none|

