export const oktaConfig = {
    clientId: '0oa91q1b03bsRbwA95d7',
    issuer: 'https://dev-79977778.okta.com/oauth2/default',
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true,
}