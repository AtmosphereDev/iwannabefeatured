# 🌟 I Wanna Be Featured
Make your server featured and look better!

![image](https://github.com/user-attachments/assets/0ecfd623-133f-4b49-96d2-059ca287e727)

# Usage
1. Copy path for your OS and choose file that often starts with `cF`
2. Edit featured servers !DON'T EDIT MINEPLEX, IT DOESN'T SHOW!
3. Download new file and replace old file with new one

<details>
<summary>Click me</summary>
  
# How resource hash name works?
It's appends `height` and `width` params to the resource url and hash with `SHA1`

### Tags
| Tag        |         params         |
|:-----------|:----------------------:|
| Thumbnails | ?height=450&width=800  |
| Icon       |  ?height=24&width=24   |
| Screenshot | ?height=162&width=288  |
| Banner     | ?height=288&width=960  |

### Example
Part from The Hive images array
```json
{
  "Id": "9a42809c-ac00-4c7b-b0b5-7741166e0eeb",
  "Tag": "Icon",
  "Type": "Screenshot",
  "Url": "https://xforgeassets002.xboxlive.com/pf-namespace-b63a0803d3653643/9a42809c-ac00-4c7b-b0b5-7741166e0eeb/29498427-bc1c-46ef-b029-f19e344741c9.jpg"
}
```
Calculate hash of url + params
```
SHA1("https://xforgeassets002.xboxlive.com/pf-namespace-b63a0803d3653643/9a42809c-ac00-4c7b-b0b5-7741166e0eeb/29498427-bc1c-46ef-b029-f19e344741c9.jpg" + "?height=24&width=24");
```
Result
```
7fc608062e09fcbddb044a5d90b843ac2424ca4a
```
</details>
