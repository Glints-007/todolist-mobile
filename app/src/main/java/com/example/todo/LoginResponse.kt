package com.example.todo

import java.io.Serializable

class LoginResponse : Serializable {
    var status_code: String
        get() {
            return status_code
        }
        set(status_code) {
            this.status_code = status_code
        }

    var access_token: String
        get() {
            return access_token
        }
        set(access_token) {
            this.access_token = access_token
        }

    var token_type: String
        get() {
            return token_type
        }
        set(token_type) {
            this.token_type = token_type
        }
}