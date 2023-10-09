// bmp.js
export let BMPGL = () => {
    return new Promise((resolve) => {
        window.init = () => {
            // eslint-disable-next-line
            resolve(BMapGL)
        }
    })
}

export const loadScript = (ak) => {
    return new Promise((reject) => {
        const script = document.createElement('script')
        script.type = 'text/javascript'
        script.src = `http://api.map.baidu.com/api?v=1.0&type=webgl&ak=${ak}&callback=init`
        script.onerror = reject
        document.head.appendChild(script)
    })
}