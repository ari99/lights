package com.me.light.loop.response.model;

import com.me.light.loop.RestartLoopException;

public interface Response {
	public void doResponse() throws RestartLoopException;
}
