import {apiGet,apiPut,apiPost} from './apiService.js'


export const addUser = (user) =>{
    if(!user){
        return false;
    }
    if (!user.userName || !user.passWord) {
        return false;
    }
    return apiPost('/api1/Test/add',user)
        .then(res =>{
            console.log('addUser success',res)
            return res.data;
        }) 
        .catch(function (error) {
            console.error('addUser error', error);
            return false;
        });
}

export const getTestOne = (num) =>{
    return apiGet(`/api1/Test/getOne?num=${num}`)
        .then(res =>{
            return res.data;
        }) 
        .catch(function (error) {
            console.error('addUser error', error);
            return false;
        })
}
export const getTestTwo = (num) =>{
    return apiPost('/api1/Test/postOne',{num})
        .then(res =>{
            return res.data;
        }) 
        .catch(function (error) {
            console.error('addUser error', error);
            return false;
        })
}
export const queryAll = ()=>{
    return apiGet('/api1/Test/query')
        .then(res =>{
            return res.data;
        })
        .catch(function (error) {
            console.error('queryAll error', error);
            return false;
        })
}