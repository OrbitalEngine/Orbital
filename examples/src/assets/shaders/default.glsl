#type vertex
#version 330 core

layout (location=0) in vec3 aPos;
layout (location=1) in vec4 aColor;

out vec4 fColor;

void main()
{
    fColor = aColor;
    gl_Position = vec4(aPos, 1.0);
}

#type frag
#version 330 core

uniform float uTime;

in vec4 fColor;
out vec4 color;

void main()
{
    // Time varying pixel color
    vec3 col = 0.5 + 0.5*cos(uTime+vec3(0,0,0)+vec3(0,2,4));

    color = vec4(col, 1.0);
}