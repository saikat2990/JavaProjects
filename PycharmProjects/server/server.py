from flask import Flask , render_template
app = Flask(__name__)

@app.route("/")
def main():
    return "SAIKAT     DADADADADADADADA   "
        #"saikat"
        #render_template("index.html")
if __name__ == "__main__":
    app.run(debug=True,host="192.168.1.104" , port=80)
