
import React, { Component } from 'react';
import { addUser,getTestOne,getTestTwo, queryAll } from '../services/user';
import { Button  } from 'antd';
import { SearchOutlined } from '@ant-design/icons';

export default class Test extends Component {


    componentDidMount = async()=>{
        const data = await getTestOne(1);
        await getTestTwo(2)
        console.log(data)
    }

    queryUser = async() =>{
        this.props.searchUser(await queryAll())  
    }
    sub = async()=>{
        let user = {
            userName:this.username.value,
            passWord:this.password.value
        }
        const data = await addUser(user);
        // if(data.data!=0){
        //     this.props.submitUser(user)
        // }
       
    }
    render() {
        return (
            <div>
                <input ref={c => this.username = c} type='text'/><br/>
                <input ref={c => this.password = c} type='password'/><br/>
                <Button onClick={this.sub} type="primary">提交数据</Button><br/>
                <Button onClick={this.queryUser} type="primary" icon={<SearchOutlined />}>点我获取用户数据</Button>
            </div>
        );
    }
}