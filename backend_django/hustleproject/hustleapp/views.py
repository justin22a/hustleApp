from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework.authentication import TokenAuthentication
from rest_framework.permissions import IsAuthenticated
from .models import UserProfile, Product, Posting
from .serializers import UserProfileSerializer, ProductSerializer, PostingSerializer
from rest_framework import status

class UserProfileView(APIView):
    def get(self, request, *args, **kwargs):
        user = request.user
        try:
            user_profile = UserProfile.objects.get(user=user)
            postings = Posting.objects.filter(user=user_profile.user)
            products = Product.objects.filter(user=user_profile.user)

            user_profile_serializer = UserProfileSerializer(user_profile)
            posting_serializers = PostingSerializer(postings, many=True)
            product_serializers = ProductSerializer(products, many=True)

            response_data = {
                'user_profile': user_profile_serializer.data,
                'postings': posting_serializers.data,
                'products': product_serializers.data
            }

            return Response(response_data, status=status.HTTP_200_OK)

        except UserProfile.DoesNotExist:
            return Response({'detail': 'User profile not found.'}, status=status.HTTP_404_NOT_FOUND)


@csrf_exempt
def api_login(request):
    if request.method == 'POST':
        data = json.loads(request.body)
        username = data.get('username')
        password = data.get('password')
        user = authenticate(username=username, password=password)

        if user:
            login(request, user)
            return JsonResponse({'message': 'Login successful'})
        else:
            return JsonResponse({'message': 'Login failed'}, status=401)