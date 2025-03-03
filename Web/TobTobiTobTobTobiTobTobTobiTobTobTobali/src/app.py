from flask import Flask, request, render_template_string, send_from_directory

app = Flask(__name__, static_folder='static')

blacklists =['os', 'sys', 'import','subprocess', 'shutil', 'tempfile', 'pickle', 'marshal',
            'write', 'eval', 'exec', 'system', 'popen', 'open',
            'call', 'check_output', 'check_call', 'startfile', 'remove', 'unlink',
            'rmdir', 'remove', 'rename', 'replace', 'chdir', 'chmod', 'chown',
            'chroot', 'link', 'lchown', 'listdir', 'lstat', 'mkdir', 'makedirs',
            'mkfifo', 'mknod', 'open', 'openpty', 'remove', 'removedirs',
            'rename', 'renames', 'rmdir', 'stat', 'symlink', 'unlink', 'walk', 'write',
            'popen', 'builtins', 'global'] 
@app.route('/static/<path:filename>')
def static_file(filename):
    return send_from_directory(app.static_folder, filename)

@app.route('/')
def index():
    return render_template_string(open('templates/index.html').read())

@app.route('/card', methods=['POST'])
def card():
    name = request.form.get('name', 'tobi')
    lname = name.lower()
    if any(word in lname for word in blacklists):
        return "TobiTob don't like that"
    style='''
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-image: url(https://static.vecteezy.com/system/resources/previews/007/197/608/non_2x/islamic-eid-mubarak-background-with-gold-lanterns-free-vector.jpg);
            background-size: cover;
            background-position: center;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            text-align: center;
        }
        img {
            width: 200px;
            height: auto;
            border-radius: 10px;
            margin-top: 10px;
        }
    </style>
'''
    template = '''
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TobTobiTobTobTobiTobTobTobiTobTobTobali</title>
    {}
</head>
<body>
    <div class="container">
        <h1>Hello {}</h1>
        <img src="/static/cat.jpg" alt="cat">
        <p>Hope you have a good Ramadhan</p>
    </div>
</body>
</html>
'''.format(style,name)
    return render_template_string(template)
if __name__ == '__main__':
    app.run(host="0.0.0.0", port=5000, debug=False)
