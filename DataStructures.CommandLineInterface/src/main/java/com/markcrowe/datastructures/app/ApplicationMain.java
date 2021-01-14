/*
 * Copyright (c) 2021 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.app;

import com.markcrowe.datastructures.PrefixTreeCommandApp;
import com.markcrowe.datastructures.PrefixTreeComponent;

/**
 *
 */
public class ApplicationMain
{
	public static void main(String args[])
	{
		var prefixTreeCommandApp = new PrefixTreeCommandApp();
		prefixTreeCommandApp.setPrefixTree(new PrefixTreeComponent<>(26));

		prefixTreeCommandApp.run();
	}
}
