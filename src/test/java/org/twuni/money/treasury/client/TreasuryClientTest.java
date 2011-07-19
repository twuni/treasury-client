package org.twuni.money.treasury.client;

import java.util.Iterator;
import java.util.Set;

import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.twuni.money.common.Token;
import org.twuni.money.common.Treasury;

public class TreasuryClientTest {

	@Ignore
	@Test
	public void doSomething() {

		DefaultHttpClient client = new DefaultHttpClient();
		Treasury treasury = new TreasuryClient( client, "home.twuni.org" );

		Token original = treasury.create( 12345 );
		Set<Token> tokens = treasury.split( original, 10000 );

		Assert.assertEquals( 2, tokens.size() );

		Iterator<Token> it = tokens.iterator();
		Token merged = treasury.merge( it.next(), it.next() );

		Assert.assertEquals( original.getValue(), merged.getValue() );

	}

}
