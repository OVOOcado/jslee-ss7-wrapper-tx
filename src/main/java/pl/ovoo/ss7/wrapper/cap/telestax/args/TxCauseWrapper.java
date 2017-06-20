/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;
import pl.ovoo.ss7.wrapper.cap.args.CauseWrapper;

/**
 * TxCauseWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCauseWrapper implements CauseWrapper {

	private final CauseIndicators cause;

	public TxCauseWrapper(final CauseIndicators cause) {
		this.cause = cause;
	}

	@Override
	public CodingStandard getCodingStandard() {
		if (cause.getCodingStandard() >= 0) {
			return CodingStandard.valueOf(cause.getCodingStandard());
		}
		return null;
	}

	@Override
	public Location getLocation() {
		if (cause.getLocation() >= 0) {
			return Location.valueOf(cause.getLocation());
		}
		return null;
	}

	@Override
	public Recommendation getRecommendation() {
		if (cause.getRecommendation() >= 0) {
			return Recommendation.valueOf(cause.getRecommendation());
		}
		return null;
	}

	@Override
	public CauseValue getCauseValue() {
		if (cause.getCauseValue() >= 0) {
			return CauseValue.valueOf(cause.getCauseValue());
		}
		return null;
	}

	@Override
	public void setCodingStandard(final CodingStandard codingStandard) {
		cause.setCodingStandard(codingStandard.getValue());
	}

	@Override
	public void setLocation(final Location location) {
		cause.setLocation(location.getValue());
	}

	@Override
	public void setRecommendation(final Recommendation recommendation) {
		cause.setRecommendation(recommendation.getValue());
	}

	@Override
	public void setCauseValue(final CauseValue causeValue) {
		cause.setCauseValue(causeValue.getValue());
	}

	@Override
	public boolean hasCauseValue() {
		return cause.getCauseValue() >= 0;
	}

	public CauseIndicators getTxCause() {
		return cause;
	}

	@Override
	public String toString() {
		return "TxCauseWrapper [cause=" + cause + "]";
	}

}
