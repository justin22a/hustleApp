from django.contrib.auth import authenticate

class UserService:
    @staticmethod
    def authenticate_user(username, password):
        user = authenticate(username=username, password=password)
        return user
