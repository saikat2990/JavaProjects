#!C:\Users\ASUS\PycharmProjects\helo\venv\Scripts\python.exe
# EASY-INSTALL-ENTRY-SCRIPT: 'pyspeedtest==1.2.7','console_scripts','pyspeedtest'
__requires__ = 'pyspeedtest==1.2.7'
import re
import sys
from pkg_resources import load_entry_point

if __name__ == '__main__':
    sys.argv[0] = re.sub(r'(-script\.pyw?|\.exe)?$', '', sys.argv[0])
    sys.exit(
        load_entry_point('pyspeedtest==1.2.7', 'console_scripts', 'pyspeedtest')()
    )
