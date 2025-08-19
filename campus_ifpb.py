import requests
from PIL import Image
from io import BytesIO

wms_url = "http://localhost:9090/geoserver/atv_bd2/wms"

paraiba_base_map_layer = "minicipiosdapb:PARAIBA_MUNICIPIOS"

params = {
    "service": "WMS",
    "version": "1.1.0",
    "request": "GetMap",
    "layers": f"{paraiba_base_map_layer},atv_bd2:campus_ifpb",
    "styles": "",
    "bbox": "-38.8,-8.5,-34.6,-6.0",
    "width": "1600",
    "height": "1200",
    "srs": "EPSG:4326",
    "format": "image/png",
    "transparent": "true"
}

response = requests.get(wms_url, params=params)

if response.status_code == 200 and "image/png" in response.headers.get("Content-Type", ""):
    image = Image.open(BytesIO(response.content))
    image.show()
    image.save("paraiba_com_campus_IFPB.png")
    print("Imagem salva como paraiba_com_campus.png")
else:
    print("Erro ao requisitar a imagem! Status:", response.status_code)
    print(response.text[:500])