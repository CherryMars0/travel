export let ageOptions = (age) => {
    return {
        backgroundColor: '#2c343c',
        title: {
            text: 'employee Age',
            left: 'center',
            top: 20,
            textStyle: {
                color: '#ccc'
            }
        },
        tooltip: {
            trigger: 'item'
        },
        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series: [
            {
                name: 'employee age',
                type: 'pie',
                radius: '55%',
                center: ['50%', '50%'],
                data: [
                    { value: age[0], name: '20~30', itemStyle: { normal: { color: '#5c5ac7' } } },
                    { value: age[1], name: '30~40', itemStyle: { normal: { color: '#fbbf0e' } } },
                    { value: age[2], name: '40~50', itemStyle: { normal: { color: '#2da04d' } } },
                    { value: age[3], name: '50~60', itemStyle: { normal: { color: '#de3529' } } },
                ].sort(function (a, b) {
                    return a.value - b.value;
                }),
                roseType: 'radius',
                label: {
                    color: 'rgba(255, 255, 255, 0.3)'
                },
                labelLine: {
                    lineStyle: {
                        color: 'rgba(255, 255, 255, 0.3)'
                    },
                    smooth: 0.2,
                    length: 10,
                    length2: 20
                },
                itemStyle: {
                    color: '#c23531',
                    shadowBlur: 200,
                    shadowColor: 'rgba(0, 0, 0, 0)'
                },
                animationType: 'scale',
                animationEasing: 'elasticOut',
            }
        ]
    }
}

export let genderOptions = (man, woman) => {
    return {
        tooltip: {
            trigger: 'item'
        },
        title: {
            text: 'employee Gender \n total:' + (man + woman),
            left: 'center',
            top: 50,
            textStyle: {
                color: '#ccc'
            }
        },
        series: [
            {
                name: 'Gender',
                type: 'pie',
                radius: ['40%', '70%'],
                center: ['50%', '70%'],
                startAngle: 180,
                label: {
                    show: true,
                    formatter(param) {
                        return param.name + ' (' + param.percent * 2 + '%)';
                    }
                },
                data: [
                    { value: man, name: 'Man' },
                    { value: woman, name: 'Woman' },
                    {
                        value: man + woman,
                        itemStyle: {
                            color: 'none',
                            decal: {
                                symbol: 'none'
                            }
                        },
                        label: {
                            show: false
                        }
                    }
                ]
            }
        ]
    }
}