package com.example.todo

class RegistResponse {
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