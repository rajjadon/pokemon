package com.raj.datasource.remote.network

import com.raj.common.error.HttpRequestError
import com.raj.common.error.HttpRequestErrorCodes
import com.raj.common.error.PokemonAppError

fun SafeApiRequest.getErrorMessage(errorCode: Int, message: String? = null): PokemonAppError {

    return when (errorCode) {
        HttpRequestErrorCodes.TimeOut.code -> HttpRequestError.TimeOut(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.ExpectationFailed.code -> HttpRequestError.ExpectationFailed(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.CONTINUE.code -> HttpRequestError.Continue(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.SWITCHING_PROTOCOLS.code -> HttpRequestError.SwitchingProtocols(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PROCESSING.code -> HttpRequestError.Processing(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.CREATED.code -> HttpRequestError.Created(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.ACCEPTED.code -> HttpRequestError.Accepted(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NON_AUTHORITATIVE_INFORMATION.code -> HttpRequestError.NonAuthoritativeInformation(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NO_CONTENT.code -> HttpRequestError.NoContent(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.RESET_CONTENT.code -> HttpRequestError.ResetContent(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PARTIAL_CONTENT.code -> HttpRequestError.PartialContent(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.MULTI_STATUS.code -> HttpRequestError.MultiStatus(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.ALREADY_REPORTED.code -> HttpRequestError.AlreadyReported(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.IM_USED.code -> HttpRequestError.ImUsed(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.MULTIPLE_CHOICES.code -> HttpRequestError.MultipleChoices(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.MOVED_PERMANENTLY.code -> HttpRequestError.MovedPermanently(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.FOUND.code -> HttpRequestError.Found(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.SEE_OTHER.code -> HttpRequestError.SeeOther(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NOT_MODIFIED.code -> HttpRequestError.NotModified(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.USE_PROXY.code -> HttpRequestError.UseProxy(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.SWITCH_PROXY.code -> HttpRequestError.SwitchProxy(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.TEMPORARY_REDIRECT.code -> HttpRequestError.TemporaryRedirect(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PERMANENT_REDIRECT.code -> HttpRequestError.PermanentRedirect(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.BAD_REQUEST.code -> HttpRequestError.BadRequest(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.UNAUTHORIZED.code -> HttpRequestError.Unauthorized(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PAYMENT_REQUIRED.code -> HttpRequestError.PaymentRequired(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.FORBIDDEN.code -> HttpRequestError.Forbidden(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NOT_FOUND.code -> HttpRequestError.NotFound(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.METHOD_NOT_ALLOWED.code -> HttpRequestError.MethodNotAllowed(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NOT_ACCEPTABLE.code -> HttpRequestError.NotAcceptable(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PROXY_AUTHENTICATION_REQUIRED.code -> HttpRequestError.ProxyAuthenticationRequired(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.REQUEST_TIMEOUT.code -> HttpRequestError.RequestTimeout(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.CONFLICT.code -> HttpRequestError.Conflict(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.GONE.code -> HttpRequestError.Gone(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.LENGTH_REQUIRED.code -> HttpRequestError.LengthRequired(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PRECONDITION_FAILED.code -> HttpRequestError.PreconditionFailed(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PAYLOAD_TOO_LARGE.code -> HttpRequestError.PayloadTooLarge(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.URI_TOO_LONG.code -> HttpRequestError.UriTooLong(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.UNSUPPORTED_MEDIA_TYPE.code -> HttpRequestError.UnsupportedMediaType(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.RANGE_NOT_SATISFIABLE.code -> HttpRequestError.RangeNotSatisfiable(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.EXPECTATION_FAILED.code -> HttpRequestError.ExpectationFailed(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.I_AM_A_TEAPOT.code -> HttpRequestError.IAmATeapot(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.MISDIRECTED_REQUEST.code -> HttpRequestError.MisdirectedRequest(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.UN_PROCESSABLE_ENTITY.code -> HttpRequestError.UnProcessableEntity(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.LOCKED.code -> HttpRequestError.Locked(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.FAILED_DEPENDENCY.code -> HttpRequestError.FailedDependency(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.UPGRADE_REQUIRED.code -> HttpRequestError.UpgradeRequired(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PRECONDITION_REQUIRED.code -> HttpRequestError.PreconditionRequired(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.TOO_MANY_REQUESTS.code -> HttpRequestError.TooManyRequests(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.REQUEST_HEADER_FIELDS_TOO_LARGE.code -> HttpRequestError.RequestHeaderFieldsTooLarge(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.UNAVAILABLE_FOR_LEGAL_REASONS.code -> HttpRequestError.UnavailableForLegalReasons(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.INTERNAL_SERVER_ERROR.code -> HttpRequestError.InternalServerError(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NOT_IMPLEMENTED.code -> HttpRequestError.NotImplemented(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.BAD_GATEWAY.code -> HttpRequestError.BadGateway(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.SERVICE_UNAVAILABLE.code -> HttpRequestError.ServiceUnavailable(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.GATEWAY_TIMEOUT.code -> HttpRequestError.GatewayTimeout(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.HTTP_VERSION_NOT_SUPPORTED.code -> HttpRequestError.HTTPVersionNotSupported(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.VARIANT_ALSO_NEGOTIATES.code -> HttpRequestError.VariantAlsoNegotiates(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.INSUFFICIENT_STORAGE.code -> HttpRequestError.InsufficientStorage(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.LOOP_DETECTED.code -> HttpRequestError.LoopDetected(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NOT_EXTENDED.code -> HttpRequestError.NotExtended(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NETWORK_AUTHENTICATION_REQUIRED.code -> HttpRequestError.TrailerAppAuthenticationRequired(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.SOMETHING_WENT_WRONG.code -> HttpRequestError.SomeThingWentWrong(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }

        else -> HttpRequestError.SomeThingWentWrong(
            code = errorCode
        ).apply {
            message?.let {
                errorMessage = it
            }
        }
    }
}