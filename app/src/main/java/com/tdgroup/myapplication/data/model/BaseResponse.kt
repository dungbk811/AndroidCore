package com.tdgroup.myapplication.data.model

class BaseResponse<T> constructor(val status : Int, val success : Boolean,val data : T) {

}