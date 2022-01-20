// contextBridge: 使用上下文隔离模式
const { contextBridge, clipboard } = require('electron');
const ipcRenderer = require('electron').ipcRenderer;
const fs = require('fs');
const NodeID3 = require('node-id3')

contextBridge.exposeInMainWorld(
    'electron',
    {
        /**
         * 在系统剪贴板上执行复制和粘贴操作
         */
        readText: () => clipboard.readText(),
        /**
         * 弹出选择文件对话框
         * @param option 选项
         */
        showOpenDialogSync: (option) => ipcRenderer.sendSync('show-open-dialog-sync', option),
        /**
         * 读取文件属性
         * @param path 文件路径
         */
        statSync: (path) => fs.statSync(path),
        /**
         * 读取媒体文件属性
         * @param path 文件路径
         * @param fn 回调函数
         */
        readMediaProp: (path, fn) => NodeID3.read(path, fn),
        /**
         * 同步地打开目录
         */
        readdirSync: (path) => fs.readdirSync(path)
    }
)