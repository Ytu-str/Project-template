import React, { Component } from 'react';
import createWebSocket from '../../services/websocket'


export default class ClientSocket extends Component {

    state = {
        data:""
    }

    ws = new createWebSocket('ws://localhost:8080/socket/luck')

    componentDidMount(){
        this.ws.getMessage().then((res)=>{
            console.log(res+"shuju000000")
            this.setState({data:res})
        })
    }
    componentDidUpdate(){
        this.ws.getMessage().then((res)=>{
            console.log(res)
            this.setState({data:res})
        })
    }

    componentWillUnmount(){
        this.ws.close()
    }

    render() {
        return (
                <div>
                    <br/>
                        <input id="text" type="text" />
                        <button >Send</button>   
                    <h1>{this.state.data}</h1>
                </div>
        );
    }
}