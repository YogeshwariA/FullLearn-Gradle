function goToAnywhereWorksSignIn() {

	const
	clientId = '29354-ad35e115205caf42fd0c391bf226ea70';
	//const redirectUrl = "http://v1-dot-full-learn-173706.appspot.com/oauth/callback";
	const redirectUrl = "http://localhost:8888/oauth/callback";
	window.location.href = 'https://access.anywhereworks.com/o/oauth2/auth?response_type=code&client_id='
			+ clientId
			+ '&max_auth_age=0'
			+ +'&access_type=offline'
			+ '&scope=awapis.identity&redirect_uri=' + redirectUrl;
}
