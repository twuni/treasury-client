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
	public void liveIntegrationTest() {

		DefaultHttpClient client = new DefaultHttpClient();
		Treasury treasury = new TreasuryClient( client, "localhost" );

		Token original = treasury.create( 12345 );
		Set<Token> tokens = treasury.split( original, 10000 );

		Assert.assertEquals( 2, tokens.size() );

		Token merged = merge( treasury, tokens );

		Assert.assertEquals( original.getValue(), merged.getValue() );

	}

	private Token merge( Treasury treasury, Set<Token> tokens ) {

		Iterator<Token> it = tokens.iterator();

		Token a = it.next();
		Token b = it.next();

		return treasury.merge( a, b );

	}

}
