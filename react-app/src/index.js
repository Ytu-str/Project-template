import React from 'react'

import reactDOM from 'react-dom'

import App from './App'
import {BrowserRouter} from 'react-router-dom'

import 'antd/dist/antd.less'

reactDOM.render( <BrowserRouter>
    <App/>
</BrowserRouter>,document.getElementById('root'))