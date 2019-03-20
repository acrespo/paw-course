
class Horoscope {

  constructor(sign, description) {
    this.sign = sign;
    this.description = description;
  }
}

function loadXMLDoc(callback) {
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      processSigns(this, callback);
    }
  };
  xmlhttp.open("GET", "data.xml", true);
  xmlhttp.send();
}

function processSigns(xml, callback) {
  
  var horoscopes = {};
  var xmlDoc = xml.responseXML;

  var signs = xmlDoc.getElementsByTagName("sign");

  for (var i = 0; i < signs.length; i++) {
    var names = signs[i].getElementsByTagName("sign-name");
    var descs = signs[i].getElementsByTagName("sign-message");

    horoscopes[names[0].innerHTML] = new Horoscope(names[0].innerHTML, descs[0].innerHTML);
  }

  callback(horoscopes);
}