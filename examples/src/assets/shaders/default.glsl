#type vertex
#version 330 core

layout (location=0) in vec3 aPos;
layout (location=1) in vec4 aColor;
layout (location=1) in vec2 aTexCoords;

out vec4 fColor;
out vec2 fTexCoords;

void main()
{
    fColor = aColor;
    fTexCoords = aTexCoords;
    gl_Position = vec4(aPos, 1.0);
}

#type frag
#version 330 core

uniform float uTime;
uniform sampler2D TEX_SAMPLER;

in vec4 fColor;
in vec2 fTexCoords;

out vec4 color;

void main()
{
//    // Time varying pixel color
//    vec3 col = 0.5 + 0.5*cos(uTime+vec3(0,0,0)+vec3(0,2,4));
//
//    color = vec4(col, 1.0);

    color = texture(TEX_SAMPLER, fTexCoords);
}