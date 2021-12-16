import React, { Component } from 'react'
import Test from './componses'
import IndexSocket from './componses/indexSocket'

import { Table  } from 'antd';
import {Link,Route,Routes} from 'react-router-dom'
import ClientSocket from './componses/clientSocket'


import './App.less'

export default class App extends Component {
  state = {
    dataSource :[]
  }


  searchUser = (dataSource )=>{
    console.log(dataSource)
    this.setState({dataSource :dataSource})
  }

  submitUser = (user)=>{

  }
    render() {
      const columns = [
        {
          title: '用户名',
          dataIndex: 'userName',
          key: 'userName',
        },
        {
          title: '密码',
          dataIndex: 'passWord',
          key: 'passWord',
        },
      ];
      const {dataSource } = this.state
        return (
            <div>
              <IndexSocket/>
              <ClientSocket/>
              <Test searchUser={this.searchUser} submitUser = {this.submitUser}/>
              <span>{this.state.dataSource.data}</span>
              <Table dataSource={dataSource} columns={columns} rowKey={record => record.id}>
                  {
                    dataSource.map((userObj)=>{
                      return <td key={userObj.id}>用户名:{userObj.userName},密码:{userObj.passWord}</td>
                    })
                  }
              </Table>
                  <div>
                  {/* <Link className="list-group-item"  to='/ClientSocket'>clientSocket</Link>
                    <br/>
                    <Link className="list-group-item"  to='/IndexSocket'>indexSocket</Link>  */}
                  </div>
              <div>
              {/* <Routes>
              <Route path='/ClientSocket' element={ClientSocket}/>
                 <Route path='/IndexSocket' element={IndexSocket}/>
              </Routes> */}
                   
              </div>
            </div>
        )
    }
}
