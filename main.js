const { app, BrowserWindow, dialog, ipcMain } = require('electron')
const pkg = require('./package.json')
const path = require('path')

let win

function createWindow() {
  win = new BrowserWindow({
    width: 1032,
    height: 670,
    webPreferences: {
      nodeIntegration: true,
      preload: path.join(__dirname, "preload.js")
    },
    frame: false,
    transparent: true
  })

  if (pkg.DEV) {
    win.loadURL("http://localhost:3000/")
  } else {
    win.loadFile('./build/index.html')
  }

  win.on('closed', () => {
    win = null
  })

}

/**
 * ready
 */
app.on('ready', createWindow)

/**
 * window-all-closed
 */
app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit()
  }
})

/**
 * activate
 */
app.on('activate', () => {
  if (win === null) {
    createWindow()
  }
})

/**
 * 打开系统对话框
 */
ipcMain.on('show-open-dialog-sync', (event, arg) => {
  event.returnValue = dialog.showOpenDialogSync(arg);
});
